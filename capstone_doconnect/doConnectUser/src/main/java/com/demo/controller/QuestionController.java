package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.helper.UploadFile;
import com.demo.model.Messages;
import com.demo.model.Question;
import com.demo.model.ResponsePage;
import com.demo.services.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class QuestionController {
	/**
	 * @see this is the user question controller
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private UploadFile uploadFile;
	@Autowired
	private QuestionService questionService;

	/**
	 * @see this api is used for insert a question
	 * @param file
	 * @param question
	 * @return response string type data
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@PostMapping("/insertQue")
	public ResponseEntity<?> userRegister(@RequestParam(value="file", required=false) MultipartFile file,
			@RequestPart(name = "question") String question) throws JsonMappingException, JsonProcessingException {
		Question questionAns = new ObjectMapper().readValue(question, Question.class);
		boolean flag = uploadFile.uploadFile(file);
        System.out.println(flag);
		if (flag) {
			String imgUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
					.path(file.getOriginalFilename()).toUriString();
			questionAns.setImg_url(imgUrl);

			
		}
		if (this.questionService.insertQuestion(questionAns)) {
			String emailSub = "New question posted: \n [Topic]: " + questionAns.getTopic();
			String emailBody = "Question Description... \n" + "\n" + "\n" + questionAns.getDescription();
			questionService.sendmail(emailSub, emailBody);
			return ResponseEntity.ok()
					.body(new ResponsePage(Messages.SUCCESS, "You have successfuly posted question!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You can not post question!"));
	}

	/**
	 * 
	 * @return this api is used for getting all question
	 * @throws Exception
	 */
	@GetMapping("/allQuestion")
	public ResponseEntity<List<Question>> getAllQuestion() throws Exception {
		List<Question> questions = this.questionService.getQuestion();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return this api is used for getting question by id
	 * @throws Exception
	 */

	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int id) throws Exception {
		Question question = this.questionService.getQuestionById(id);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		boolean flag = uploadFile.uploadFile(file);
        System.out.println(flag);
		if (flag) {
			String imgUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
					.path(file.getOriginalFilename()).toUriString();
			System.out.println(imgUrl);
			return ResponseEntity.ok()
					.body(new ResponsePage(Messages.SUCCESS, "You have successfuly uploaded file!"));

		}
		return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE, "You can not upload file!"));
	}

}
