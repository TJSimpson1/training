import { useNavigate, useParams } from "react-router-dom"

const ResultPage = () => {

    const params = useParams()
    const navigate = useNavigate()

    const showCalculatorPage = () => {
        navigate('/calculator')
    }

    return(
        <div>
            <h1>{params.value}</h1>
            <button type="submit" onClick={showCalculatorPage}>Calculator</button>
        </div>
    )
}

export default ResultPage