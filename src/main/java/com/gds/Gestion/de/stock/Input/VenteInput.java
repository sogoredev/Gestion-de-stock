package com.gds.Gestion.de.stock.Input;

import com.gds.Gestion.de.stock.DTOs.ProduitDTO;
import com.gds.Gestion.de.stock.entites.Vente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteInput {
//    test
    private int idVenteProduit;
    private int quantite;
    private int reduction;
    private List<ProduitDTO> produit;
    private Vente vente;
}
