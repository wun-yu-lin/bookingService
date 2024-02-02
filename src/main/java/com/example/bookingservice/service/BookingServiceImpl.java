package com.example.bookingservice.service;

import com.example.bookingservice.constant.BookingMode;
import com.example.bookingservice.dao.AirBookingRepository;
import com.example.bookingservice.dao.OceanBookingRepository;
import com.example.bookingservice.dto.BookingDto;
import com.example.bookingservice.exception.DataNoFoundException;
import com.example.bookingservice.model.AirBookingModel;
import com.example.bookingservice.model.OceanBookingModel;
import com.example.bookingservice.vo.BookingVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
public class BookingServiceImpl implements BookingService{

    private AirBookingRepository airBookingRepository;
    private OceanBookingRepository oceanBookingRepository;

    //DI
    public BookingServiceImpl(AirBookingRepository airBookingRepository, OceanBookingRepository oceanBookingRepository) {
        this.airBookingRepository = airBookingRepository;
        this.oceanBookingRepository = oceanBookingRepository;
    }


    @Override
    public BookingVO getBookingByIdAndMode(int bookingId, BookingMode mode) throws DataNoFoundException {

        BookingVO bookingVO = new BookingVO();
        if (mode == BookingMode.air){
             Optional<AirBookingModel> airBookingModel =  airBookingRepository.findById(bookingId);
             if (airBookingModel.isPresent()) {
                 bookingVO.setCargo(airBookingModel.get().getCargo());
                 bookingVO.setFrom(airBookingModel.get().getLoading());
                 bookingVO.setTo(airBookingModel.get().getDischarge());
                 bookingVO.setQuantity(airBookingModel.get().getQuantity());
                 bookingVO.setMode(BookingMode.air);
                 bookingVO.setId(airBookingModel.get().getId());
             }

        }else if (mode == BookingMode.ocean) {
            Optional<OceanBookingModel> oceanBookingModel = oceanBookingRepository.findById(bookingId);
            if (oceanBookingModel.isPresent()){
                bookingVO.setCargo(oceanBookingModel.get().getCargo());
                bookingVO.setFrom(oceanBookingModel.get().getLoading());
                bookingVO.setTo(oceanBookingModel.get().getDischarge());
                bookingVO.setQuantity(oceanBookingModel.get().getQuantity());
                bookingVO.setMode(BookingMode.ocean);
                bookingVO.setId(oceanBookingModel.get().getId());
            }
        }
        if (bookingVO.getCargo() == null && bookingVO.getFrom() == null && bookingVO.getTo() == null){
            throw new DataNoFoundException("Data not found where id=" + bookingId + " and mode=" + mode.getModeName());
        }
        return  bookingVO;
    }

    @Override
    @Transactional
    public BookingVO postBooking(BookingDto bookingDto) {
        BookingVO bookingVO = new BookingVO();

        //判斷是哪種運輸方式, 存入對應的資料表
        if (bookingDto.getMode() == BookingMode.air){
            AirBookingModel airBookingModel = new AirBookingModel();
            airBookingModel.setCargo(bookingDto.getCargo());
            airBookingModel.setLoading(bookingDto.getFrom());
            airBookingModel.setDischarge(bookingDto.getTo());
            airBookingModel.setQuantity(bookingDto.getQuantity());
            AirBookingModel vo =  airBookingRepository.save(airBookingModel);
            bookingVO.setId(vo.getId());
            bookingVO.setCargo(vo.getCargo());
            bookingVO.setFrom(vo.getLoading());
            bookingVO.setTo(vo.getDischarge());
            bookingVO.setQuantity(vo.getQuantity());
            bookingVO.setMode(BookingMode.air);

        }else if (bookingDto.getMode() == BookingMode.ocean) {
            OceanBookingModel oceanBookingModel = new OceanBookingModel();
            oceanBookingModel.setCargo(bookingDto.getCargo());
            oceanBookingModel.setLoading(bookingDto.getFrom());
            oceanBookingModel.setDischarge(bookingDto.getTo());
            oceanBookingModel.setQuantity(bookingDto.getQuantity());

            OceanBookingModel vo =  oceanBookingRepository.save(oceanBookingModel);
            bookingVO.setId(vo.getId());
            bookingVO.setCargo(vo.getCargo());
            bookingVO.setFrom(vo.getLoading());
            bookingVO.setTo(vo.getDischarge());
            bookingVO.setQuantity(vo.getQuantity());
            bookingVO.setMode(BookingMode.ocean);

        }


        return bookingVO;

    }

    @Override
    @Transactional
    public void deleteBookingByIdAndMode(int bookingId, BookingMode mode) {
        if (mode == BookingMode.air) {
            airBookingRepository.deleteById(bookingId);
        } else if (mode == BookingMode.ocean) {
            oceanBookingRepository.deleteById(bookingId);
        }

    }
}
