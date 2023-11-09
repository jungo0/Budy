import logo from '../assets/images/logo.png';
import styled from 'styled-components';

const HeaderContainer = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #f0f0f0;
`;

const LogoContainer = styled.div`
  display: flex;
  align-items: center;
`;

const StyledLogoIcon = styled.img`
  width: 30px;
  height: 30px;
  margin-right: 10px;
`;

const Header = () => {
  const logoContainerStyle = {
    display: 'flex',
    alignItems: 'center',
  };

  return (
    <HeaderContainer>
      <LogoContainer style={logoContainerStyle}>
        <div style={{ width: '30px', height: '30px', marginRight: '10px' }}>
          <StyledLogoIcon src={logo} alt="Logo Icon" />
        </div>
        <h1 style={{ fontSize: '1.2rem', margin: '0' }}>BUDY</h1>
      </LogoContainer>
      <div style={{ display: 'flex', gap: '10px' }}>
        <button
          style={{
            padding: '5px 10px',
            color: 'black',
            border: 'none',
            borderRadius: '5px',
            cursor: 'pointer',
          }}
        >
          로그인
        </button>
        <button
          style={{
            padding: '5px 10px',
            color: 'black',
            border: 'none',
            borderRadius: '5px',
            cursor: 'pointer',
          }}
        >
          회원가입
        </button>
      </div>
    </HeaderContainer>
  );
};

export default Header;
