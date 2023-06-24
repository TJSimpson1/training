import '../styles/ProductCard.css'

const ProductCard = (props) => {

    const {name, description, price} = props.product

    return(
        <div className="card">
            <h2>{name}</h2>
            <p className='description'>{description}</p>
            <div>
                <p className='price'>Price: £{price}</p>
                <button className='addButton'>Add to basket</button>
            </div>
        </div>
    )

}

export default ProductCard