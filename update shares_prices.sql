/********************************************************************************************************
 * This script changes the time_start and time_end values in shares_prices table in the following way:  *
 * 1) time_start is changed to 9 am (the original date is left unchanged)                               *
 * 2) time end of each record is changed to the date value of time_start-1 with the time of 6 pm        *
 *    of the record with the next later time_start for the same share_id,                               *
 *    except for the latest time_start for each share_id, where time_end is left to null                *
 * This change produces three kinds of records in shares_prices table:                                  *
 * 1) shares that have changed their price within the same day (818 records)                            *
 * 2) shares that have not changed their price within the same day (297 records)                        *
 * 3) shares that have not changed their price yet (don't have time_end set yet) (8 records)            *
 ********************************************************************************************************/

DECLARE 

  CURSOR share_id_cur IS
     SELECT share_id
     FROM shares_prices
     ORDER BY share_id ASC;
  share_id_rec share_id_cur%rowtype;
  
  CURSOR earliest_time_start_cur (current_share_id NUMBER) IS
      SELECT sp1.share_id, 
             sp1.time_start
      FROM shares_prices sp1
      WHERE sp1.share_id = current_share_id
      AND sp1.time_end IS NULL
      AND TO_CHAR(sp1.time_start, 'DD-MM-YYYY') = (SELECT TO_CHAR(MIN(sp2.time_start), 'DD-MM-YYYY')
                                                   FROM shares_prices sp2
                                                   WHERE sp2.time_end IS NULL
                                                   AND sp2.share_id = sp1.share_id);
  earliest_time_start_rec earliest_time_start_cur%rowtype;

  CURSOR next_earliest_time_start_cur (current_share_id NUMBER) IS
      SELECT sp1.share_id, 
             sp1.time_start
      FROM shares_prices sp1
      WHERE sp1.share_id = current_share_id
      AND sp1.time_end IS NULL
      AND TO_CHAR(sp1.time_start, 'DD-MM-YYYY') = (SELECT TO_CHAR(MIN(sp2.time_start), 'DD-MM-YYYY')
                                                   FROM shares_prices sp2
                                                   WHERE sp2.time_end IS NULL
                                                   AND sp2.share_id = sp1.share_id);
  next_earliest_time_start_rec next_earliest_time_start_cur%rowtype;

BEGIN 
   OPEN share_id_cur; 
   LOOP 
      FETCH share_id_cur into share_id_rec;      
      EXIT WHEN share_id_cur%notfound; 
      OPEN earliest_time_start_cur(share_id_rec.share_id);
      LOOP
         FETCH earliest_time_start_cur into earliest_time_start_rec;
         EXIT WHEN earliest_time_start_cur%notfound; 
         -- insert a temporary date (tomorrow) into time_end field of the current earliest_time_start_rec
         -- so that the next earliest date for the same share_id can be found
         UPDATE shares_prices SET time_end = SYSDATE + 1 -- tomorrow
         WHERE share_id = share_id_rec.share_id
         AND time_start LIKE earliest_time_start_rec.time_start;

         OPEN next_earliest_time_start_cur(share_id_rec.share_id);
         LOOP
            FETCH next_earliest_time_start_cur into next_earliest_time_start_rec;
            EXIT WHEN next_earliest_time_start_cur%notfound; 
            -- update the time_end value of the record with the earliest_time_start_rec.time_start
            -- for the current share_id to 6pm of the day before the value of the next_earliest_time_start_rec.time_start 
            UPDATE shares_prices SET time_end = TO_DATE(TO_CHAR(next_earliest_time_start_rec.time_start - 1, 'DD-MM-YYYY') || ' 18:00:00', 'DD-MM-YYYY HH24:MI:SS')
            WHERE share_id = share_id_rec.share_id
            AND time_start LIKE earliest_time_start_rec.time_start;
            -- set the time_start to 9 am (leaving the date unchanged) for the same record
            UPDATE shares_prices SET time_start = TO_DATE(TO_CHAR(time_start, 'DD-MM-YYYY') || ' 09:00:00', 'DD-MM-YYYY HH24:MI:SS')
            WHERE share_id = share_id_rec.share_id
            AND time_start LIKE earliest_time_start_rec.time_start;
         END LOOP;
         CLOSE next_earliest_time_start_cur;
      END LOOP;
      CLOSE earliest_time_start_cur;
   END LOOP; 
   CLOSE share_id_cur;
   -- set the time_start to 9 am (leaving the date unchanged) in all records where time_end is tomorrow's date
   UPDATE shares_prices SET time_start = TO_DATE(TO_CHAR(time_start, 'DD-MM-YYYY') || ' 09:00:00', 'DD-MM-YYYY HH24:MI:SS')
   WHERE time_end LIKE SYSDATE + 1;         
   -- change the time_end back to null in all records where time_end is tomorrow's date
   UPDATE shares_prices SET time_end = null
   WHERE time_end LIKE SYSDATE + 1;         
   -- commit the changes
   COMMIT;
END; 
/ 