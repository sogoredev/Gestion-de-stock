package com.gds.Gestion.de.stock.security;

import com.gds.Gestion.de.stock.DTOs.AuthentificationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Builder
@AllArgsConstructor
@Slf4j
public class SecurityController {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> conexion(@RequestBody AuthentificationDTO authentificationDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
            );
            String token = jwtService.genererToken(authentificationDTO.username()).get("bearer");
            return ResponseEntity.ok(Map.of("token", token));
        } catch (BadCredentialsException e) {
            log.error("Identifiants incorrects pour l'utilisateur : " + authentificationDTO.username());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Identifiants incorrects"));
        } catch (Exception e) {
            log.error("Erreur lors de l'authentification : ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Erreur serveur"));
        }
    }
}

