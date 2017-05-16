package org.realworld.webservice.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.bearerHeader}")
    private String bearerHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // get auth header supporting both Token and Bearer as the header value
        String authToken = request.getHeader(this.tokenHeader);
        if (StringUtils.isEmpty(authToken)) {
            authToken = request.getHeader(this.bearerHeader);
        }

        // get username from the auth request and if valid perform authentication
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if ( !(StringUtils.isEmpty(username)) && (SecurityContextHolder.getContext().getAuthentication() == null) ) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
            // the database compellingly. Again it's up to you ;)
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.print("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }

}
