import { Route, Routes } from 'react-router-dom';
import './App.css';
import ListProducts from './components/ListProducts';
import RegisterProduct from './components/RegisterProduct';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element = {<ListProducts/>}/>
        <Route path="/products" element = {<ListProducts/>}/>
        <Route path="/register" element = {<RegisterProduct/>}/>
      </Routes>
    </div>
  );
}

export default App;
