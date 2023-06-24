import { Link } from 'react-router-dom'
import '../styles/Navbar.css'

const Navbar = () => {
    return(
        <div>
        <ul>
            <li><Link to='/home'>Home</Link></li>
            <li><Link to='/news'>News</Link></li>
            <li><Link to='/contact'>Contact</Link></li>
            <li><Link to='/about'>About</Link></li>
        </ul>
        </div>
    )
}

export default Navbar