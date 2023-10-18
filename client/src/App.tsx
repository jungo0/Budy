import { Route, Routes } from 'react-router-dom';
import Main from './pages/main/Main';
import Login from './pages/users/Login';
import Mypage from './pages/mypage/Mypage';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="/login" element={<Login />} />
      <Route path="/mypage/:id" element={<Mypage />} />
    </Routes>
  );
}

export default App;
