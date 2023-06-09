package co.gov.heqc.healthcite.mappers.impl;

import co.gov.heqc.healthcite.dto.request.AppointmentRequestDto;
import co.gov.heqc.healthcite.dto.response.AppointPatientResponseDto;
import co.gov.heqc.healthcite.dto.response.AppointmentResponseDto;
import co.gov.heqc.healthcite.entities.AppointmentEntity;
import co.gov.heqc.healthcite.mappers.AppointmentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentEntity toAppointmentEntity(AppointmentRequestDto appointmentRequest) {

        if (appointmentRequest == null) {
            return null;
        }

        AppointmentEntity entity = new AppointmentEntity();
        entity.setDescription(appointmentRequest.getDescription() );
        entity.setAttentionDate( appointmentRequest.getAttentionDate() );
        entity.setCitationDate( appointmentRequest.getCitationDate() );
        entity.setStatus(appointmentRequest.getStatus() );
        entity.setReason(appointmentRequest.getReason() );
        entity.setSymptoms(appointmentRequest.getSymptoms() );

        return entity;
    }

    @Override
    public AppointmentResponseDto toAppointmentResponse(AppointmentEntity appointmentEntity) {

        if (appointmentEntity == null) {
            return null;
        }

        AppointmentResponseDto response = new AppointmentResponseDto();

        response.setId( appointmentEntity.getId() );
        response.setDescription( appointmentEntity.getDescription() );
        response.setAttentionDate( appointmentEntity.getAttentionDate() );
        response.setCitationDate( appointmentEntity.getCitationDate() );
        response.setStatus( appointmentEntity.getStatus() );
        response.setReason( appointmentEntity.getReason() );
        response.setSymptoms( appointmentEntity.getSymptoms() );
        response.setEps( appointmentEntity.getEps().getName() );
        response.setPatientName( appointmentEntity.getPatient().getFirstName() );
        response.setPatientDocument( appointmentEntity.getPatient().getDocument() );
        response.setPatientPhone( appointmentEntity.getPatient().getPhone() );

        return response;
    }

    @Override
    public List<AppointmentResponseDto> toResponseList(List<AppointmentEntity> appointmentEntityList) {

        if (appointmentEntityList == null || appointmentEntityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<AppointmentResponseDto> list = new ArrayList<>(appointmentEntityList.size());

        for (AppointmentEntity apointment :
                appointmentEntityList) {
            list.add(toAppointmentResponse(apointment) );
        }

        return list;
    }

    @Override
    public AppointPatientResponseDto toPatientResponse(AppointmentEntity appointmentEntity) {

        if (appointmentEntity == null) {
            return null;
        }

        AppointPatientResponseDto response = new AppointPatientResponseDto();

        response.setId( appointmentEntity.getId() );
        response.setDescription( appointmentEntity.getDescription() );
        response.setCitationDate( appointmentEntity.getCitationDate() );
        response.setStatus( appointmentEntity.getStatus() );
        response.setEps( appointmentEntity.getEps().getName() );
        response.setDoctorName( appointmentEntity.getDoctor().getFirstName() );
        response.setDoctorDocument( appointmentEntity.getDoctor().getDocument() );
        response.setDoctorPhone( appointmentEntity.getDoctor().getPhone() );

        return response;
    }

    @Override
    public List<AppointPatientResponseDto> toPatientResponseList(List<AppointmentEntity> appointmentEntityList) {
        if (appointmentEntityList == null || appointmentEntityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<AppointPatientResponseDto> list = new ArrayList<>(appointmentEntityList.size());

        for (AppointmentEntity apointment :
                appointmentEntityList) {
            list.add(toPatientResponse(apointment) );
        }

        return list;
    }


}
