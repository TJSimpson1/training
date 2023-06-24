import { useState, useEffect } from "react"
import ProductCard from "./ProductCard"
import axios from "axios"
import { Link } from "react-router-dom"

const ListProducts = () => {

    const [products, setProducts] = useState([])

    const api = 'http://localhost:8088/api/v1/products'

    const loadProducts = () => {
        axios.get(api)
                .then(response => {setProducts(response.data)})
                .catch(error => console.log('Unable to load data'))
    }

    useEffect(() => {
        loadProducts()
    }, [])

    return(
        <div>
            {
                products.map(
                    product => <ProductCard key={product.id} product={product}/>
                )
            }
            <Link to = "/register">Add product</Link>
        </div>
    )

}

export default ListProducts