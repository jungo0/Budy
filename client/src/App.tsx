import { Routes, useLocation } from 'react-router-dom';
import { RouteList } from './RouteList';
import { useState } from 'react';
import Header from './share/Header';
import useRouteAnimation from './hooks/useRouteAnimation';
import styled from 'styled-components';

const MainContent = styled.div`
  flex-grow: 1;
`;

function App() {
  const location = useLocation();
  const [displayLocation, setDisplayLocation] = useState(location);
  const [transitionStage, setTransitionStage] = useState('fadeIn');
  useRouteAnimation(location, displayLocation, setDisplayLocation, setTransitionStage);
  return (
    <>
      <Header />
      <div
        className={`${transitionStage}`}
        style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}
      >
        <MainContent>
          <Routes location={displayLocation}>{RouteList}</Routes>
        </MainContent>
      </div>
    </>
  );
}

export default App;
