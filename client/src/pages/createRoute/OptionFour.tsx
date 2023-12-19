import prev_arrow from '../../assets/images/img_option/prev_arrow.png';
import next_arrow from '../../assets/images/img_option/next_arrow.png';
import {
  ButtonContainer,
  CalButton,
  Container,
  InputBox,
  ListBox,
  ListContainer,
  ListContent,
  ListLabel,
  ListLabel2,
  TimeButton,
  Title,
  PrevArrow,
  NextArrow,
} from './OptionFour.style';

function OptionFour() {
  return (
    <Container>
      <Title>출발지 정보를 입력해주세요</Title>
      <ButtonContainer>
        <PrevArrow src={prev_arrow} style={{ left: '-90px' }}></PrevArrow>
        <CalButton>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>날짜 선택</div>
        </CalButton>
        <TimeButton>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>시간 선택</div>
        </TimeButton>
        <NextArrow src={next_arrow} style={{ right: '-90px' }}></NextArrow>
      </ButtonContainer>
      <InputBox placeholder="출발지 검색하기" />
      <ListContainer>
        <ListBox>
          <ListLabel>리스트 항목 1</ListLabel>
          <ListContent>지도보기</ListContent>
          <ListLabel2>세부정보</ListLabel2>
        </ListBox>
        <ListBox>
          <ListLabel>리스트 항목 2</ListLabel>
          <ListContent>지도보기</ListContent>
          <ListLabel2>세부정보</ListLabel2>
        </ListBox>
        {/* 추가적인 리스트 항목들 */}
      </ListContainer>
    </Container>
  );
}

export default OptionFour;
