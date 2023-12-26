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
import { useEffect, useRef, useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
function OptionFour() {
  const [startDate, setStartDate] = useState<Date | null>(null);
  const [startTime, setStartTime] = useState<Date | null>(null);
  const [isDatePickerVisible, setDatePickerVisible] = useState(false);
  const [isTimePickerVisible, setTimePickerVisible] = useState(false);
  const datePickerRef = useRef(null);
  const timePickerRef = useRef(null);

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

  return (
    <Container>
      <Title>출발지 정보를 입력해주세요</Title>
      <ButtonContainer>
        <PrevArrow src={prev_arrow} style={{ left: '-90px' }}></PrevArrow>
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
        <NextArrow src={next_arrow} style={{ right: '-90px' }}></NextArrow>
      </ButtonContainer>
      {isDatePickerVisible && (
        <DatePicker
          selected={startDate}
          onChange={handleDateChange}
          dateFormat="yyyy-MM-dd"
          ref={datePickerRef}
          popperPlacement="bottom-start"
        />
      )}
      {isTimePickerVisible && (
        <DatePicker
          selected={startTime}
          onChange={handleTimeChange}
          showTimeSelect
          showTimeSelectOnly
          timeCaption="시간"
          dateFormat="h:mm aa"
          ref={timePickerRef}
        />
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
