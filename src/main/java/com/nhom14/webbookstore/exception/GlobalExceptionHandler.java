package com.nhom14.webbookstore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e,
	RedirectAttributes redirectAttributes) {
	redirectAttributes.addAttribute("message", "Tệp vượt quá kích thước cho phép là 1MB"); 
	return "redirect:/viewaccount";
	}
	// Các phương thức xử lý ngoại lệ khác...
	
}