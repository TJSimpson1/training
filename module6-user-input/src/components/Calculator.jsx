import { useState } from "react"

const Calculator = () => {

    const [firstNumber, setFirstNumber] = useState(0)
    const [secondNumber, setSecondNumber] = useState(0)
    const [message, setMessage] = useState('')

    const calculate = (event) => {
        event.preventDefault()
        setMessage(firstNumber + " + " + secondNumber + " = " + (Number(firstNumber) + Number(secondNumber)))
    }

    const resetPage = (event) => {
        event.preventDefault()
        setFirstNumber(0)
        setSecondNumber(0)
        setMessage('')
    }

    return(
        <div>
            <form onSubmit={calculate}>
                <input name='firstNumber' type="number" value={firstNumber} onChange={event => setFirstNumber(event.target.value)}/>
                +
                <input name='secondNumber' type="number" value={secondNumber} onChange={event => setSecondNumber(event.target.value)} />
                <input value='Calculate' type='submit'/>
                <input value='Reset' type="button" onClick={resetPage}/>
            </form>
            <h2>{message}</h2>
        </div>
    )
}

export default Calculator