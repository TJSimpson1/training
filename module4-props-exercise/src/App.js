import './App.css';
import UserCard from './components/UserCard';

function App() {
  return (
    <div className="App">
      <UserCard fullName="John Smith" username="johnsmith1" email="john_smith@yahoo.com" phoneNumber={75765765}/>
      <UserCard fullName="Jane Jones" username="jane.jones" email="janejones@gmail.com" phoneNumber={87685685}/>
      <UserCard fullName="John Doe" username="jdoe" email="jdoe@outlook.com" phoneNumber={12345678}/>
    </div>
  );
}

export default App;
