import './App.css';
import MainDash from './components/MainDash/MainDash';
import RightSide from './components/RigtSide/RightSide';
import Sidebar from './components/LeftSide/Sidebar';
import Submit from './components/Submit/Submit';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <div className="AppGlass">
          <Sidebar />
          <Routes>
            <Route path="/" element={<MainDash />} />
            <Route path="/submit" element={<Submit />} />
          </Routes>
          <RightSide />
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;