import styled from 'styled-components';
import bus from '../../assets/images/img_option/opt2_bus.png';
import prev_arrow from '../../assets/images/img_option/prev_arrow.png';
import next_arrow from '../../assets/images/img_option/next_arrow.png';
import {
  Container,
  ButtonContainer,
  Button,
  BusImage,
  TextContainer,
  InputBox,
  InputContainer,
  PlusMinusButton,
  ButtonGroup,
  InputWrapper,
} from './OptionTwo.style';
const Arrow = styled.img`
  width: 10px;
  height: 20px;
  margin-top: 20%;
  cursor: pointer;
  position: absolute;
  bottom: 90%;
`;
const PrevArrow = styled(Arrow)``;
const NextArrow = styled(Arrow)``;

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
      <h1 style={{ fontSize: '1.3rem', marginBottom: '-50px' }}>몇 인승이 필요하신가요?</h1>
      <ButtonContainer>
        <PrevArrow src={prev_arrow} style={{ left: '-70px' }}></PrevArrow>
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
        <NextArrow src={next_arrow} style={{ right: '-70px' }}></NextArrow>
      </ButtonContainer>
    </Container>
  );
}

export default OptionTwo;
