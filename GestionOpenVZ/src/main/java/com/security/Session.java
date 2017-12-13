package com.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Session {

	public String getCurrentUserName() {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return ((UserDetails) principal).getUsername();
	}

	public String getCurrentUserRole() {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return ((UserDetails) principal).getAuthorities().toString()
				.replace('[', ' ').replace(']', ' ').trim();
	}

}
