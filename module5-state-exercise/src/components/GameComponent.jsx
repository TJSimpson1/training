import { useState } from "react"
import RandomNumberComponent from "./RandomNumberComponent"

const GameComponent = () => {

    const [number, setNumber] = useState(0)

    const [message, setMessage] = useState("")

    const [prediction, setPrediction] = useState("")

    const buttonClicked = (somePrediction) => {
        setPrediction(somePrediction)
        setMessage("Your prediction is: "+somePrediction+". Click generate random number to find out.")
    }

    const checkPrediction = (someNumber) => {
        setMessage("You guessed wrongly!")
        
        if((someNumber > number && prediction === "higher") || (someNumber < number && prediction === "lower")){
            setMessage("You guessed correctly!")
        }
        
        setNumber(someNumber)
    }

    return(
        <div>
            <RandomNumberComponent parentMethod={checkPrediction}/>
            <h1>Will the next number be higher or lower??</h1>
            <div>
                <button type="button" onClick={() => buttonClicked("higher")}>Higher</button>
                <button type="button" onClick={() => buttonClicked("lower")}>Lower</button>
            </div>
            {message}
        </div>
    )
}

export default GameComponent