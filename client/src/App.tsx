import { Route, Routes, useLocation } from 'react-router-dom';
import Main from './pages/main/Main';
import Login from './pages/users/Login';
import Mypage from './pages/mypage/Mypage';
import { RouteList } from './RouteList';
import { useState } from 'react';
import useAxiosInterceptor from './hooks/useAxiosInterceptor';
import useRouteAnimation from './hooks/useRouteAnimation';

function App() {
  const location = useLocation();
  const [displayLocation, setDisplayLocation] = useState(location);
  const [transitionStage, setTransitionStage] = useState('fadeIn');
  useRouteAnimation(location, displayLocation, setDisplayLocation, setTransitionStage);
  useAxiosInterceptor();
  return (
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="/login" element={<Login />} />
      <Route path="/mypage/:id" element={<Mypage />} />
    </Routes>
  );
}

export default App;
