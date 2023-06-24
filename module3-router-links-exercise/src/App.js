import { Route, Routes } from 'react-router-dom';
import './App.css';
import Footer from './components/Footer';
import Navbar from './components/Navbar';
import Home from './components/Home'
import News from './components/News'
import Contact from './components/Contact'
import About from './components/About'

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Routes>
        <Route path='/' element = {<Home/>}/>
        <Route path='/home' element = {<Home/>}/>
        <Route path='/news' element = {<News/>}/>
        <Route path='/contact' element = {<Contact/>}/>
        <Route path='/about' element = {<About/>}/>
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
