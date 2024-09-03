// https://openclassrooms.com/fr/courses/6100311-testez-votre-code-java-pour-realiser-des-applications-de-qualite/6441536-implementez-les-differents-types-de-tests-d-integration
// https://github.com/geoffreyarthaud/oc-testing-java-cours/tree/master/src 

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	@Mock
	Calculator calculator;

	@Mock
	SolutionFormatter solutionFormatter;

	CalculatorService classUnderTest;

	@BeforeEach
	public void init() {
		classUnderTest = new CalculatorServiceImpl(calculator, solutionFormatter);
	}

	@Test
	public void calculate_shouldUseCalculator_forAddition() {
		// GIVEN
		when(calculator.add(1, 2)).thenReturn(3);

		// WHEN
		final int result = classUnderTest.calculate(
				new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

		// THEN
		verify(calculator).add(1, 2);
		assertThat(result).isEqualTo(3);
	}

}