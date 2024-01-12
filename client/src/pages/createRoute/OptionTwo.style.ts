import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: var(--back-gray);
  position: relative;
`;

export const ButtonContainer = styled.div`
  display: flex;
  position: relative;
  margin-top: 80px;
`;

export const Button = styled.button`
  width: 110px;
  height: 150px;
  background-color: white;
  margin-inline: 10px;
  border: none;
  cursor: pointer;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  position: relative;
  border-radius: 8px 8px 0 0;
  overflow: hidden;

  &:active {
    transform: scale(0.98);
  }
`;

export const BusImage = styled.img`
  width: 80%;
  height: 60%;
  position: absolute;
  top: 16%;
  left: 11%;
  z-index: 0;
`;

export const TextOverlay = styled.div`
  position: absolute;
  top: 4%;
  left: 5%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  gap: 5px;
  border-radius: 10px;
  padding: 10px;

  & p {
    color: #b67900;
    font-size: 0.7rem;
  }
`;

export const TextOverlay2 = styled.div`
  position: absolute;
  top: 4%;
  left: 5%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  gap: 5px;
  border-radius: 10px;
  padding: 10px;

  & p {
    color: #1a69a9;
    font-size: 0.7rem;
  }
`;

export const TextContainer = styled.div`
  text-align: center;
  margin: 20px 0;
  width: 100%;
  max-width: 400px;
  box-sizing: border-box;
  margin-top: -10%;
`;

export const InputContainer = styled.div`
  width: 100%;
  max-width: 400px;
  margin: 50px 0;
  text-align: center;
`;

export const InputBox = styled.div`
  width: 100%;
  height: 40px;
  resize: none;
  background-color: var(--gray);
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 1rem;
`;

export const InputWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
`;

export const ButtonGroup = styled.div`
  display: flex;
  gap: 15px;
  align-items: center;
  width: 120px;
`;

export const PlusMinusButton = styled.button`
  width: 20px;
  height: 20px;
  background-color: #ccc;
  border: none;
  border-radius: 40%;
  cursor: pointer;
  font-weight: bold;
  color: var(--dark-gray);
  margin: 0;

  &:active {
    background-color: #999;
  }
`;

export const CountSpan = styled.span`
  font-size: 14px;
  width: 20px;
`;
