package TestRailClient;

import java.util.List;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.TestRail.Builder;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;

import abstractComponents.ApiResources;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestRailApiClient {
		private static final String BASE_URL = "https://shinchantest.testrail.io/";
		private static final String USERNAME = "ss367940@gmail.com";
		private static final String API_KEY = "88.MlzXJPav5P7ShxGp9-.50d0sXBAzCaxFo8E69m";
		private static final int PROJECT_ID = 2;
		private static final int MILESTONE_ID = 6;
		public static void cereateTestRun(String name) {
			// https://shinchantest.testrail.io/index.php?/runs/add/6&suite_id=9&name=Automated%20Run
			String endPoint =
			String.format("index.php?/api/v2/add_run/%d", PROJECT_ID);
			Response resp = RestAssured.given().baseUri(BASE_URL ).header("Content-Type","application/json").log().all().auth().preemptive().basic(USERNAME, API_KEY).body("{\r\n"
					+ "\"suite_id\" : 9,\r\n"
					+ "\"milestone_id\" : "+MILESTONE_ID+",\r\n"
					+ "\"name\" : \"Automated run\"\r\n"
					+ "}").post(endPoint);
			System.out.println(resp.asString());
			}
		public static  void updateTestResult() {
			TestRail testRail = TestRail.builder(BASE_URL,USERNAME,API_KEY).applicationName("Test").build();
			List<ResultField> customResultFields = testRail.resultFields().list().execute();
			testRail.results().addForCase(18,3822, new Result().setStatusId(1), customResultFields).execute();
		}
}
