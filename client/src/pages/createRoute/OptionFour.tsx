import styled from 'styled-components';
import cal from '../../assets/images/img_option/opt4_calender.png';
import clock from '../../assets/images/img_option/opt4_clock.png';
import mak from '../../assets/images/img_option/opt4_mak.png';
import search from '../../assets/images/img_option/opt4_serach.png';
export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: var(--back-gray);
  position: relative;
`;

export const Title = styled.h1`
  font-size: 1.6rem;
  margin-bottom: 20px;
`;

export const ButtonContainer = styled.div`
  display: flex;
  position: relative;
  gap: 20px;
`;

export const Button = styled.button`
  width: 150px;
  height: 40px;
  background-color: white;
  border: 1px solid #ccc;
  cursor: pointer;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const CalButton = styled(Button)`
  border-radius: 5px;
  background: url(${cal}) no-repeat right center;
  background-size: 20px;
  background-position: 9px center;
  background-color: var(--gray);
`;

export const TimeButton = styled(Button)`
  border-radius: 5px;
  background: url(${clock}) no-repeat left center;
  background-size: 20px;
  background-position: 9px center;
  background-color: var(--gray);
`;

export const TextContainer = styled.div`
  text-align: center;
  margin: 20px;
  width: 100%;
  max-width: 400px;
  box-sizing: border-box;
`;

export const InputBox = styled.textarea`
  margin: 15px 0;
  width: 31.6%;
  height: 40px;
  resize: none;
  background-color: var(--gray);
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  font-size: 0.9rem;
`;
export const ListContainer = styled.div`
  background-color: white;
  border-radius: 10px;
  padding: 20px;
  width: 70%;
  max-width: 320px;
  height: 390px;
  overflow-y: auto;
  margin: 4px 0;
  border: 1px solid #ccc;
`;

export const ListBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-bottom: 30px;
  border-bottom: 1px solid #ccc;
`;

export const ListLabel = styled.div`
  font-size: 1rem;
  color: var(--bright-gray);
`;
export const ListLabel2 = styled.div`
  font-size: 0.9rem;
  color: var(--dark-gray);
  margin-top: -42px;
`;
export const ListContent = styled.button`
  font-size: 1rem;
  color: var(--dark-gray);
  background-color: transparent;
  border: 1px solid #ccc;
  padding: 7px;
  margin-top: 5px;
  border-radius: 5px;
  cursor: pointer;
  align-self: flex-end; /* 오른쪽 정렬 */
  margin-bottom: 30px; /* 오른쪽 간격 조정 */
  margin-left: auto; /* 나머지 공간을 왼쪽으로 정렬 */
`;

function OptionFour() {
  return (
    <Container>
      <Title>출발지 정보를 입력해주세요</Title>
      <ButtonContainer>
        <CalButton>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>날짜 선택</div>
        </CalButton>
        <TimeButton>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>시간 선택</div>
        </TimeButton>
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
