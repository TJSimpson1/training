import { useState } from "react"
import '../styles/RegisterProduct.css'

const RegisterProduct = () => {

    const [name, setName] = useState('')
    const [description, setDescription] = useState('')
    const [price, setPrice] = useState(0)

    const [nameInvalid, setNameInvalid] = useState(false)
    const [descriptionInvalid, setDescriptionInvalid] = useState(false)
    const [priceInvalid, setPriceInvalid] = useState(false)

    const handleSubmit = (event) => {
        event.preventDefault()
        setNameInvalid(false)
        setDescriptionInvalid(false)
        setPriceInvalid(false)
        if(name === ''){
            setNameInvalid(true)
        }
        if(description === ''){
            setDescriptionInvalid(true)
        }
        if(Number(price) < 0){
            setPriceInvalid(true)
        }
    }

    return(
        <div className="registerProduct">
            <h1>Enter product details: </h1>
            <form onSubmit={handleSubmit}>
                <label>Name: </label>
                <input type="text" name="username" value={name} onChange={event => setName(event.target.value)} /> 
                {nameInvalid && <div className="error">Name cannot be blank</div>} <br/>
                <label>Description: </label>
                <input type="text" name="description" value={description} onChange={event => setDescription(event.target.value)} />
                {descriptionInvalid && <div className="error">Description cannot be blank</div>} <br/>
                <label>Price: </label>
                <input type="number" name="price" value={price} onChange={event => setPrice(event.target.value)} />
                {priceInvalid && <div className="error">Price cannot be negative</div>} <br/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}

export default RegisterProduct