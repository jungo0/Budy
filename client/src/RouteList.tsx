import { Route } from 'react-router-dom';
import Main from './pages/main/Main';
import Login from './pages/users/Login';
import Mypage from './pages/mypage/Mypage';
import OptionOne from './pages/createRoute/OptionOne';
import OptionTwo from './pages/createRoute/OptionTwo';
import OptionThree from './pages/createRoute/OptionThree';
import OptionFour from './pages/createRoute/OptionFour';
import OptionFive from './pages/createRoute/OptionFive';
import ShoppingCart from './pages/order/ShoppingCart';
import Payment from './pages/order/Payment';

// Route에 Auth 추가
export const routes = [
  { path: '/', element: <Main /> },
  { path: '/login', element: <Login /> },
  { path: '/mypage/:id', element: <Mypage /> },
  { path: '/option-one', element: <OptionOne /> },
  { path: '/option-two', element: <OptionTwo /> },
  { path: '/option-three', element: <OptionThree /> },
  { path: '/option-four', element: <OptionFour /> },
  { path: '/option-five', element: <OptionFive /> },
  { path: '/cart', element: <ShoppingCart /> },
  { path: '/payment', element: <Payment /> },
];

export const RouteList = (
  <Route>
    {routes.map((route, index) => (
      <Route key={index} path={route.path} element={route.element} />
    ))}
  </Route>
);
