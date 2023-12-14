package com.nhom14.webbookstore.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nhom14.webbookstore.entity.Account;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e,
			RedirectAttributes redirectAttributes,
			HttpSession session) {
		redirectAttributes.addAttribute("message", "Tệp vượt quá kích thước cho phép là 1MB"); 
		if((Account) session.getAttribute("admin") != null) {
			Account acc_fix_img = (Account)session.getAttribute("acc_fix_img");
			return "redirect:/managedetailaccount?accountId=" + acc_fix_img.getId();
		}
		return "redirect:/viewaccount";
	}
	// Các phương thức xử lý ngoại lệ khác...
	
}