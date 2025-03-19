package com.gds.Gestion.de.stock.services;

import com.gds.Gestion.de.stock.DAO.VenteDAO;
import com.gds.Gestion.de.stock.DTOs.ApprovisionDTO;
import com.gds.Gestion.de.stock.DTOs.VenteDTO;
import com.gds.Gestion.de.stock.exceptions.EmptyException;
import com.gds.Gestion.de.stock.exceptions.VenteNotFoundException;

import java.util.List;

public interface InterfaceVente {

    void effectuerVente(VenteDTO venteDTO) throws Exception;
    void modifierVente(VenteDTO venteDTO) throws EmptyException, VenteNotFoundException;
    VenteDAO afficherVente(String idVente) throws VenteNotFoundException;
    List<VenteDAO> listerVente();
    long totalVente();
    void supprimerVente(String venteId) throws VenteNotFoundException;

    void annulerVente(VenteDTO venteDTO) throws EmptyException;
}
