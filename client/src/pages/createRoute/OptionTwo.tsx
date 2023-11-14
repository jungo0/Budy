import styled from 'styled-components';
import bus from '../../assets/images/img_option/opt2_bus.png';

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
  margin-top: -30%;
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
  gap: 5px;
`;

export const PlusMinusButton = styled.button`
  width: 20px;
  height: 20px;
  background-color: #ccc;
  border: none;
  border-radius: 40%;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  color: var(--dark-gray);
`;

export const Heading = styled.h1`
  font-size: 1.3rem;
  margin-bottom: -50px;
`;

function OptionTwo() {
  return (
    <Container>
      <TextContainer>
        <p style={{ fontSize: '1.3rem', marginTop: '5rem', marginBottom: '-2.8rem' }}>
          탑승인원이 어떻게 되시나요?
        </p>
      </TextContainer>
      <InputContainer>
        <InputWrapper>
          <InputBox>
            성인
            <ButtonGroup>
              <PlusMinusButton>-</PlusMinusButton>
              <span>0</span>
              <PlusMinusButton>+</PlusMinusButton>
            </ButtonGroup>
          </InputBox>
        </InputWrapper>
        <InputWrapper>
          <InputBox>
            청소년
            <ButtonGroup>
              <PlusMinusButton>-</PlusMinusButton>
              <span>0</span>
              <PlusMinusButton>+</PlusMinusButton>
            </ButtonGroup>
          </InputBox>
        </InputWrapper>
        <InputWrapper>
          <InputBox>
            어린이
            <ButtonGroup>
              <PlusMinusButton>-</PlusMinusButton>
              <span>0</span>
              <PlusMinusButton>+</PlusMinusButton>
            </ButtonGroup>
          </InputBox>
        </InputWrapper>
      </InputContainer>

      <Heading>몇 인승이 필요하신가요?</Heading>

      <ButtonContainer>
        <Button color="lightblue">
          <div
            style={{
              backgroundColor: '#2D98ED',
              width: '100%',
              padding: '6px',
              borderRadius: '8px 8px 0 0',
              marginTop: '8rem',
            }}
          >
            <p style={{ fontSize: '1.1rem', color: 'white' }}>18인승</p>
            <BusImage src={bus} alt="Bus 1" />
          </div>
        </Button>
        <Button color="lightblue">
          <div
            style={{
              backgroundColor: '#2D98ED',
              width: '100%',
              padding: '6px',
              borderRadius: '8px 8px 0 0',
              marginTop: '8rem',
            }}
          >
            <p style={{ fontSize: '1.1rem', color: 'white' }}>28인승</p>
            <BusImage src={bus} alt="Bus 1" />
          </div>
        </Button>
        <Button color="lightcoral">
          <div
            style={{
              backgroundColor: '#2D98ED',
              width: '100%',
              padding: '6px',
              borderRadius: '8px 8px 0 0',
              marginTop: '8rem',
            }}
          >
            <p style={{ fontSize: '1.1rem', color: 'white' }}>44인승</p>
            <BusImage src={bus} alt="Bus 2" />
          </div>
        </Button>
      </ButtonContainer>
    </Container>
  );
}

export default OptionTwo;
