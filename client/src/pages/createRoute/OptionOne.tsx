import bus1 from '../../assets/images/img_option/opt1_bus1.png';
import bus2 from '../../assets/images/img_option/opt1_bus2.png';
import {
  Container,
  ButtonContainer,
  Button,
  TextOverlay,
  TextOverlay2,
  BusImage,
  TextContainer,
  InputBox,
  InputContainer,
} from './OptionOne';

function OptionOne() {
  return (
    <Container>
      <h1 style={{ fontSize: '2rem', marginBottom: '50px' }}>노션 구분을 선택해주세요</h1>
      <ButtonContainer>
        <Button color="lightblue">
          <TextOverlay>
            <p>텍스트 1</p>
            <p>텍스트 2</p>
          </TextOverlay>
          <div
            style={{
              backgroundColor: '#D38E05',
              width: '100%',
              padding: '6px',
              borderRadius: '8px 8px 0 0',
              marginTop: '10.4rem',
            }}
          >
            <p style={{ fontSize: '1.1rem', color: 'white' }}>왕복노선</p>
            <BusImage src={bus1} alt="Bus 1" />
          </div>
        </Button>

        <Button color="lightcoral">
          <TextOverlay2>
            <p>ㅁㅁㅁ</p>
            <p>ㅁㅁㅁ</p>
          </TextOverlay2>
          <div
            style={{
              backgroundColor: '#2D98ED',
              width: '100%',
              padding: '6px',
              borderRadius: '8px 8px 0 0',
              marginTop: '10.4rem',
            }}
          >
            <p style={{ fontSize: '1.1rem', color: 'white' }}>편도노선</p>
            <BusImage src={bus2} alt="Bus 2" />
          </div>
        </Button>
      </ButtonContainer>
      <TextContainer>
        <p style={{ fontSize: '1.5rem', marginTop: '4rem', marginBottom: '-1.2rem' }}>
          노선에 대해 소개해주세요
        </p>
      </TextContainer>

      <InputContainer>
        <InputBox placeholder="ex)수원역에서 광명역까지 한번에 가는 노선입니다." />
      </InputContainer>
    </Container>
  );
}

export default OptionOne;
