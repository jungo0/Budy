import React from 'react';
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

const LogoIcon = styled.img`
  width: 30px;
  height: 30px;
  margin-right: 10px;
`;

const LogoText = styled.h1`
  font-size: 1.5rem;
  margin: 0;
`;

const AuthButtons = styled.div`
  display: flex;
  gap: 10px;
`;

const AuthButton = styled.button`
  padding: 5px 10px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
`;

const Header: React.FC = () => {
  return (
    <HeaderContainer>
      <LogoContainer>
        <LogoIcon src="/path-to-your-logo-icon.png" alt="Logo Icon" />
        <LogoText>Logo</LogoText>
      </LogoContainer>
      <AuthButtons>
        <AuthButton>Login</AuthButton>
        <AuthButton>Sign Up</AuthButton>
      </AuthButtons>
    </HeaderContainer>
  );
};

export default Header;
