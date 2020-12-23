package com.nazarova.back.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazarova.back.model.Staff;
import com.nazarova.back.repository.StaffRepository;
import com.nazarova.back.service.StaffService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
class StaffControllerTest {

    //    static final Map<Long, Staff> staffs = new HashMap<>();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private StaffController staffController;

    @Mock
    StaffService staffService;

    @MockBean
    StaffRepository staffRepository;

//    @BeforeAll
//    static void beforeAll() {
////        staffs.put(0L,new Staff(0L,"штаб1", new Date(1009138921000L)));
////        staffs.put(0L,new Staff(1L,"штаб2", new Date(1009138921000L)));
////        staffs.put(0L,new Staff(2L,"штаб3", new Date(1009138921000L)));
//         }


    @Test
    void getAllStaffTest() throws Exception {
        Staff staff1 = new Staff(1L, "штаб1", new Date(1009138921000L));
        Staff staff2 = new Staff(2L, "штаб2", new Date(1009138921000L));
        staffRepository.save(staff1);
        staffRepository.save(staff2);
        Mockito.when(staffService.getAllStaff()).thenReturn(Arrays.asList(staff1, staff2));
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
        ResultActions resultActions = mockMvc.perform(
                get("/staff"))
                .andExpect(status().isOk())
                //.andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(Arrays.asList(staff1, staff2))));
        ;
    }


    @Test
    void addStaff() throws Exception {

        Staff staff = new Staff(1L, "штаб1", new Date(1009138921000L));
        Mockito.when(staffRepository.save(Mockito.any())).thenReturn(staff);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
        mockMvc.perform(
                post("/staff")
                        .content(objectMapper.writeValueAsString(staff))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());
//                .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(staff)));

    }

//    @Test
//    void deleteStaff() {
//
////      Staff staff =new  Staff(0L,"штаб1", new Date(1009138921000L));
////        Mockito.when(staffRepository.findById(Mockito.any())).thenReturn(Optional.of(staff));
////
////        mockMvc.perform(
////            //    deleteStaff("/persons/1")
////                .andExpect(status().isOk());
//
//    }

}
