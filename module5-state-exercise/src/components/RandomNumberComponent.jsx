import { useState } from "react"

const RandomNumberComponent = (props) => {

    const [randomNumber, setRandomNumber] = useState(0)

    const generateRandomNumber = () => {
        let generatedNumber = Math.floor(Math.random()*100)
        setRandomNumber(generatedNumber)
        props.parentMethod(generatedNumber)
    }

    return(
        <div>
            <h1>{randomNumber}</h1>
            {/* <button onClick={event => setRandomNumber(Math.floor(Math.random()*100))}>Generate Random Number</button> */}
            <button onClick={generateRandomNumber}>Generate Random Number</button>
        </div>
    )

}

export default RandomNumberComponent