import { useState } from "react"
import { useNavigate } from "react-router-dom"

const Calculator = () => {

    const [firstNumber, setFirstNumber] = useState(0)
    const [secondNumber, setSecondNumber] = useState(0)

    const navigate = useNavigate()

    const calculate = () => {
        const value = Number(firstNumber) + Number(secondNumber)
        navigate('/result/'+value)
    }


    return(
        <div>
            <form onSubmit={calculate}>
                <input name='firstNumber' type="number" value={firstNumber} onChange={event => setFirstNumber(event.target.value)}/>
                +
                <input name='secondNumber' type="number" value={secondNumber} onChange={event => setSecondNumber(event.target.value)} />
                <input value='Calculate' type='submit'/>
            </form>
        </div>
    )
}

export default Calculator