module es.juliogtrenard.gestionarpersonasBBDDV2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens es.juliogtrenard.gestionarpersonasBBDDV2 to javafx.fxml;
    exports es.juliogtrenard.gestionarpersonasBBDDV2;
    exports es.juliogtrenard.gestionarpersonasBBDDV2.controladores;
    exports es.juliogtrenard.gestionarpersonasBBDDV2.modelos;
    exports es.juliogtrenard.gestionarpersonasBBDDV2.dao;
    exports es.juliogtrenard.gestionarpersonasBBDDV2.db;
    opens es.juliogtrenard.gestionarpersonasBBDDV2.controladores to javafx.fxml;
    opens es.juliogtrenard.gestionarpersonasBBDDV2.modelos to javafx.fxml;
}