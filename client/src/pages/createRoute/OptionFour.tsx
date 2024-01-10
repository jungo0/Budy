import prev_arrow from '../../assets/images/img_option/prev_arrow.png';
import next_arrow from '../../assets/images/img_option/next_arrow.png';
import { useNavigate } from 'react-router-dom';
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
import { useEffect, useRef, useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import styled from 'styled-components';

const StyledDatePicker = styled(DatePicker)`
  font-size: 20px;
  color: var(--dark-gray);
`;

const StyledContainer = styled.div`
  /* 커스텀 스타일 */
`;
const DarkBackground = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 100;
`;

function OptionFour() {
  const [startDate, setStartDate] = useState<Date | null>(null);
  const [startTime, setStartTime] = useState<Date | null>(null);
  const [isDatePickerVisible, setDatePickerVisible] = useState(false);
  const [isTimePickerVisible, setTimePickerVisible] = useState(false);
  const datePickerRef = useRef(null);
  const timePickerRef = useRef(null);

  const navigate = useNavigate();

  const handleCalButtonClick = () => {
    setDatePickerVisible(!isDatePickerVisible);
    setTimePickerVisible(false);
  };

  const handleTimeButtonClick = () => {
    setTimePickerVisible(!isTimePickerVisible);
    setDatePickerVisible(false);
  };

  const handleCalButtonInputChange = () => {
    // CalButton을 클릭하면 DatePicker 입력 칸이 나오도록 DatePicker를 열기
    if (!isDatePickerVisible && datePickerRef.current) {
      datePickerRef.current.setOpen(true);
    }
  };

  const handleDateChange = (date: Date | null) => {
    setStartDate(date);
  };

  const handleTimeChange = (time: Date | null) => {
    setStartTime(time);
  };

  useEffect(() => {
    if (isDatePickerVisible && datePickerRef.current) {
      datePickerRef.current.setOpen(true);
    }

    if (isTimePickerVisible && timePickerRef.current) {
      timePickerRef.current.setOpen(true);
    }
  }, [isDatePickerVisible, isTimePickerVisible]);

  const closeDatePicker = () => {
    setDatePickerVisible(false);
  };

  const closeTimePicker = () => {
    setTimePickerVisible(false);
  };

  useEffect(() => {
    const handleDocumentClick = (event: MouseEvent) => {
      const target = event.target as HTMLElement;

      // 날짜 선택 창이 열려있고, 클릭이 날짜 선택 창 외부에서 발생한 경우 창을 닫음
      if (isDatePickerVisible && datePickerRef.current && !datePickerRef.current.contains(target)) {
        closeDatePicker();
      }

      // 시간 선택 창이 열려있고, 클릭이 시간 선택 창 외부에서 발생한 경우 창을 닫음
      if (isTimePickerVisible && timePickerRef.current && !timePickerRef.current.contains(target)) {
        closeTimePicker();
      }
    };

    const handleKeyDown = (event: KeyboardEvent) => {
      // 날짜 선택 창이 열려있고, Enter 키가 눌린 경우 창을 닫음
      if (isDatePickerVisible && event.key === 'Enter') {
        closeDatePicker();
      }

      // 시간 선택 창이 열려있고, Enter 키가 눌린 경우 창을 닫음
      if (isTimePickerVisible && event.key === 'Enter') {
        closeTimePicker();
      }
    };

    // 컴포넌트가 마운트될 때 이벤트 리스너를 추가하고, 언마운트될 때 제거함
    document.addEventListener('click', handleDocumentClick);
    document.addEventListener('keydown', handleKeyDown);

    return () => {
      document.removeEventListener('click', handleDocumentClick);
      document.removeEventListener('keydown', handleKeyDown);
    };
  }, [isDatePickerVisible, isTimePickerVisible]);
  const handlePrevClick = () => {
    navigate('/option-three');
  };

  const handleNextClick = () => {
    navigate('/option-five');
  };
  return (
    <Container>
      <Title>출발지 정보를 입력해주세요</Title>
      <ButtonContainer>
        <PrevArrow src={prev_arrow} style={{ left: '-90px' }} onClick={handlePrevClick}></PrevArrow>
        <CalButton onClick={handleCalButtonClick} onFocus={handleCalButtonInputChange}>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>
            {startDate ? startDate.toLocaleDateString() : '날짜 선택'}
          </div>
        </CalButton>
        <TimeButton onClick={handleTimeButtonClick}>
          <div style={{ fontSize: '1rem', color: 'var(--bright-gray)' }}>
            {startTime ? startTime.toLocaleTimeString() : '시간 선택'}
          </div>
        </TimeButton>
        <NextArrow
          src={next_arrow}
          style={{ right: '-90px' }}
          onClick={handleNextClick}
        ></NextArrow>
      </ButtonContainer>
      {isDatePickerVisible && (
        <DarkBackground>
          <StyledDatePicker
            selected={startDate}
            onChange={handleDateChange}
            dateFormat="yyyy-MM-dd"
            ref={datePickerRef}
            popperPlacement="bottom-start"
          />
        </DarkBackground>
      )}
      {isTimePickerVisible && (
        <DarkBackground>
          <StyledDatePicker
            selected={startTime}
            onChange={handleTimeChange}
            showTimeSelect
            showTimeSelectOnly
            timeCaption="시간"
            dateFormat="h:mm aa"
            ref={timePickerRef}
          />
        </DarkBackground>
      )}
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
