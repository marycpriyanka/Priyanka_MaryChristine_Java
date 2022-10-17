package com.company.monthmath.controllers;

import com.company.monthmath.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // Object mapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private String inputJson;
    private String mapJson;
    @Before
    public void setUp() throws  Exception{
        // Input to be used for all tests with valid inputs
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(6);
        inputMath.setOperand2(3);

        // Convert Java object to JSON
        inputJson = mapper.writeValueAsString(inputMath);

        // Input to be used when 2 strings are passed instead of numbers (invalid input)
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("operand1", "stringValue");
        inputMap.put("operand2", "anotherString");

        mapJson = mapper.writeValueAsString(inputMap);
    }

    /**
     * Tests the endpoint "/add" for adding 2 numbers
     * @throws Exception
     */
    @Test
    public void shouldAddTwoNumbers() throws Exception {
        mockMvc.perform(post("/add")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.operation").value("add"))
                .andExpect(jsonPath("$.operand1").value(6))
                .andExpect(jsonPath("$.operand2").value(3))
                .andExpect(jsonPath("$.answer").value(9))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    /**
     * Tests the endpoint "/add" when either 1 or both operands are missing
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsMissingOnAdd() throws Exception {
        // Operand 1 missing
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(5);

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Operand 2 missing
        MathSolution inputMath2 = new MathSolution();
        inputMath2.setOperand1(5);

        // Convert Java object to JSON
        String inputJson2 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/add")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Both Operands missing
        MathSolution inputMath3 = new MathSolution();

        // Convert Java object to JSON
        String inputJson3 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/add")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    /**
     * Tests the endpoint "/add" when operands are not numbers
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsAreNotNumbersOnAdd() throws Exception {
        mockMvc.perform(post("/add")
                        .content(mapJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Operands should be both numbers"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    /**
     * Tests the endpoint "/subtract" for subtracting 2 numbers
     * @throws Exception
     */
    @Test
    public void shouldSubtractTwoNumbers() throws Exception {
        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.operation").value("subtract"))
                .andExpect(jsonPath("$.operand1").value(6))
                .andExpect(jsonPath("$.operand2").value(3))
                .andExpect(jsonPath("$.answer").value(3))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    /**
     * Tests the endpoint "/subtract" when either 1 or both operands are missing
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsMissingOnSubtract() throws Exception {
        // Operand 1 missing
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(5);

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Operand 2 missing
        MathSolution inputMath2 = new MathSolution();
        inputMath2.setOperand1(5);

        // Convert Java object to JSON
        String inputJson2 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/subtract")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Both Operands missing
        MathSolution inputMath3 = new MathSolution();

        // Convert Java object to JSON
        String inputJson3 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/subtract")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    /**
     * Tests the endpoint "/subtract" when operands are not numbers
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsAreNotNumbersOnSubtract() throws Exception {
        mockMvc.perform(post("/subtract")
                        .content(mapJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Operands should be both numbers"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    @Test
    public void shouldMultiplyTwoNumbers() throws Exception {
        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.operation").value("multiply"))
                .andExpect(jsonPath("$.operand1").value(6))
                .andExpect(jsonPath("$.operand2").value(3))
                .andExpect(jsonPath("$.answer").value(18))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    /**
     * Tests the endpoint "/multiply" when either 1 or both operands are missing
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsMissingOnMultiply() throws Exception {
        // Operand 1 missing
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(5);

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Operand 2 missing
        MathSolution inputMath2 = new MathSolution();
        inputMath2.setOperand1(5);

        // Convert Java object to JSON
        String inputJson2 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/multiply")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Both Operands missing
        MathSolution inputMath3 = new MathSolution();

        // Convert Java object to JSON
        String inputJson3 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/multiply")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    /**
     * Tests the endpoint "/multiply" when operands are not numbers
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsAreNotNumbersOnMultiply() throws Exception {
        mockMvc.perform(post("/multiply")
                        .content(mapJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Operands should be both numbers"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    @Test
    public void shouldDivideTwoNumbers() throws Exception {
        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.operation").value("divide"))
                .andExpect(jsonPath("$.operand1").value(6))
                .andExpect(jsonPath("$.operand2").value(3))
                .andExpect(jsonPath("$.answer").value(2))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    /**
     * Tests the endpoint "/divide" when either 1 or both operands are missing
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsMissingOnDivide() throws Exception {
        // Operand 1 missing
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand2(5);

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Operand 2 missing
        MathSolution inputMath2 = new MathSolution();
        inputMath2.setOperand1(5);

        // Convert Java object to JSON
        String inputJson2 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/divide")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());

        // Both Operands missing
        MathSolution inputMath3 = new MathSolution();

        // Convert Java object to JSON
        String inputJson3 = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/divide")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Missing operands"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    @Test
    public void shouldReturnErrorWhenOperand2IsZeroOnDivide() throws Exception {
        // Operand 2 is zero
        MathSolution inputMath = new MathSolution();
        inputMath.setOperand1(5);
        inputMath.setOperand2(0);

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Operand 2 is zero"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }

    /**
     * Tests the endpoint "/divide" when operands are not numbers
     * @throws Exception
     */
    @Test
    public void shouldReturnErrorWhenOperandsAreNotNumbersOnDivide() throws Exception {
        mockMvc.perform(post("/divide")
                        .content(mapJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMsg").value("Operands should be both numbers"))
                .andExpect(jsonPath("$.status").value(422))
                .andExpect(jsonPath("$.errorCode").value("422 UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }
}