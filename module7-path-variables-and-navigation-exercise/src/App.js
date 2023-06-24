import { Route, Routes } from 'react-router-dom';
import './App.css';
import Calculator from './components/Calculator'
import ResultPage from './components/ResultPage'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Calculator/>} />
        <Route path='/calculator' element={<Calculator/>} />
        <Route path='/result/:value' element={<ResultPage/>} />
      </Routes>
    </div>
  );
}

export default App;
