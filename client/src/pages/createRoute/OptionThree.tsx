import { useNavigate } from 'react-router-dom';
import styled, { css, StyledProps } from 'styled-components';
import prev_arrow from '../../assets/images/img_option/prev_arrow.png';
import next_arrow from '../../assets/images/img_option/next_arrow.png';
import { useState } from 'react';

interface ButtonProps {
  focus?: boolean;
}

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
`;

const buttonStyles = css`
  width: 140px;
  height: 60px;
  background-color: white;
  border: 1px solid var(--light-gray);
  cursor: pointer;
  font-size: 1.2rem;
  overflow: hidden;
`;

export const Button = styled.button<ButtonProps>`
  ${buttonStyles}
`;

export const LeftButton = styled(Button)<ButtonProps>`
  border-radius: 10px 0px 0px 10px;
  background-color: ${(props) => (props.focus ? 'var(--option)' : 'white')};
  color: ${(props) => (props.focus ? 'white' : 'black')};
`;

export const RightButton = styled(Button)<ButtonProps>`
  border-radius: 0px 10px 10px 0px;
  background-color: ${(props) => (props.focus ? 'var(--option)' : 'white')};
  color: ${(props) => (props.focus ? 'white' : 'black')};
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

function OptionThree() {
  const navigate = useNavigate();
  const [selectedButton, setSelectedButton] = useState<'left' | 'right' | null>(null);

  const handlePrevClick = () => {
    navigate('/option-two');
  };

  const handleNextClick = () => {
    navigate('/option-four');
  };

  return (
    <Container>
      <h1 style={{ fontSize: '1.8rem', marginBottom: '50px' }}>노션 구분을 선택해주세요</h1>
      <ButtonContainer>
        <PrevArrow
          src={prev_arrow}
          style={{ left: '-110px', bottom: '-10px' }}
          onClick={handlePrevClick}
        ></PrevArrow>
        <LeftButton onClick={() => setSelectedButton('left')} focus={selectedButton === 'left'}>
          단행노선
        </LeftButton>
        <RightButton onClick={() => setSelectedButton('right')} focus={selectedButton === 'right'}>
          정기노선
        </RightButton>
        <NextArrow
          src={next_arrow}
          style={{ right: '-110px', bottom: '-10px' }}
          onClick={handleNextClick}
        ></NextArrow>
      </ButtonContainer>
      <TextContainer>
        <p style={{ fontSize: '1.5rem', marginTop: '4rem', marginBottom: '-1.2rem' }}>
          노선에 태그를 추가해주세요
        </p>
      </TextContainer>
      <InputContainer>
        <InputBox placeholder="ex)수원역에서 광명역까지 한번에 가는 노선입니다." />
      </InputContainer>
    </Container>
  );
}

export default OptionThree;
