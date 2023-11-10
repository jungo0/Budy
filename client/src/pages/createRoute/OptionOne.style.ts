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
  gap: 20px;
  position: relative;
`;

export const Button = styled.button`
  width: 140px;
  height: 200px;
  background-color: white;
  margin-inline: 20px;
  border: none;
  cursor: pointer;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  position: relative;
  border-radius: 8px 8px 0 0;
  overflow: hidden;
`;

export const BusImage = styled.img`
  width: 50%;
  height: 50%;
  position: absolute;
  top: 30%;
  left: 50%;
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
`;

export const InputContainer = styled.div`
  width: 100%;
  max-width: 400px;
  margin: 20px 0;
  text-align: center;
`;

export const InputBox = styled.textarea`
  width: 100%;
  height: 60px;
  resize: none;
  background-color: var(--gray);
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  box-sizing: border-box;
`;
