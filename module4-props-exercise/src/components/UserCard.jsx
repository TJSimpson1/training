import '../styles/UserCard.css'

const UserCard = (props) => {
    return(
        <div className='userCard'>
            <h1>{props.fullName}</h1>
            <p>Username: {props.username}</p>
            <p>Email: {props.email}</p>
            <p>Phone: {props.phoneNumber}</p>

            <button type="button">Update</button>
            <button type="button">Delete</button>
        </div>
    )
}

export default UserCard