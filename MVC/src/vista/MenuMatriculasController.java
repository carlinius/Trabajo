
package vista;

import baseDatos.BaseDatos;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Matricula;
import principal.MVC;


public class MenuMatriculasController implements Initializable {

    MVC ventana;
    BaseDatos bd = null;
    
    @FXML
    private TableColumn c_matricula;
    @FXML
    private TableColumn c_nombre;
    @FXML
    private TableColumn c_apellido;
    @FXML
    private TableColumn c_numeroRegistro;
    @FXML
    private TableColumn c_sexo;
    @FXML
    private TableColumn c_fechaNacimiento;
    @FXML
    private TableColumn c_fechaIngreso;
    @FXML
    private TableColumn c_grado;
    @FXML
    private JFXComboBox<String> combo_sexo;
    @FXML
    private JFXComboBox<String> combo_grado;
    @FXML
    private TableView<Matricula> tablaMatriculas;
    @FXML
    private JFXTextField numeroMatricula_text;
    @FXML
    private JFXTextField nombre_text;
    @FXML
    private JFXTextField apellido_text;
    @FXML
    private JFXTextField numeroRegistroCivil_text;
    @FXML
    private JFXDatePicker fechaNacimiento_text;
    @FXML
    private JFXDatePicker fechaIngreso_Text;
    
    ObservableList<Matricula> obsLista = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     obsLista.clear();
     tablaMatriculas.setEditable(true);
      bd = new BaseDatos();
      llenarColumn();
      agregarMatriculas();
    }    
    
    public void setVentanaPrincipal(MVC ventana)
    {
     this.ventana = ventana;
    }
    
    void llenarColumn()
    {
        c_matricula.setCellValueFactory(new PropertyValueFactory<Matricula, String>("NumeroMatricula")); 
        c_nombre.setCellValueFactory(new PropertyValueFactory<Matricula, String>("Nombre")); 
        c_apellido.setCellValueFactory(new PropertyValueFactory<Matricula, String>("Apellido")); 
        c_numeroRegistro.setCellValueFactory(new PropertyValueFactory<Matricula, String>("NumeroRegistroCivil")); 
        c_sexo.setCellValueFactory(new PropertyValueFactory<Matricula, String>("Sexo")); 
        c_fechaNacimiento.setCellValueFactory(new PropertyValueFactory<Matricula, Integer>("FechaNacimiento")); 
        c_fechaIngreso.setCellValueFactory(new PropertyValueFactory<Matricula, Integer>("FechaIngreso")); 
        c_grado.setCellValueFactory(new PropertyValueFactory<Matricula, String>("Grado")); 
        tablaMatriculas.setItems(obsLista);
        
        agregarSexoCombox();
        agregarGradoCombox();
    
    }
    
    void agregarSexoCombox()
    {
        combo_sexo.getItems().add("MASCULINO");
        combo_sexo.getItems().add("FEMENINO");
    }
    
    void agregarGradoCombox()
    {
        combo_grado.getItems().add("INICIACION");
        combo_grado.getItems().add("PARBULOS");
        combo_grado.getItems().add("GUARDERIA");
        combo_grado.getItems().add("JARDIN");
    }
     
    void agregarMatriculas()
    {
         List<Matricula> lista = bd.SELECT_MATRICULAS();

        if (!lista.isEmpty()) 
        {
            
                for (int i = 0; i < lista.size(); i++) 
                {
                    obsLista.add(lista.get(i));
                }
        }
    }
    
    @FXML
    void limpiarCampos()
    {
        
        numeroMatricula_text.setText("");
        nombre_text.setText("");
        apellido_text.setText("");
        numeroRegistroCivil_text.setText("");
        combo_sexo.setValue(""); 
        combo_grado.setValue("");
    }  
    @FXML
    void registrarEmpleado()
    {
        String matricula= numeroMatricula_text.getText();
        String nombre = nombre_text.getText();
        String Apellido =apellido_text.getText();
        String registroCivil = numeroRegistroCivil_text.getText();
        String sexo = combo_sexo.getValue();
        String fechaNacimiento = fechaNacimiento_text.getValue() + "";
        String fechaIngreso = fechaIngreso_Text.getValue() +"";
        String grado = combo_grado.getValue();

        Matricula nuevo =  new Matricula(matricula,nombre,Apellido,registroCivil,sexo,fechaNacimiento,fechaIngreso,grado);
        obsLista.add(nuevo);
        
        
        if(!bd.INSERT_MATRICULA(nuevo)) 
        {
            
            mensaje("EXITO", "SE REGISTRO LA MATRICULA CON EXITO", Alert.AlertType.CONFIRMATION);
        }
        
    }
    
    @FXML 
    void actualizarMatricula()
    {
    if (!tablaMatriculas.getSelectionModel().isEmpty()) 
        {
            String numeroMatricula = tablaMatriculas.getSelectionModel().getSelectedItem().getNumeroMatricula(); 
            String nombre = nombre_text.getText();
            String apellido =apellido_text.getText();
            String registroCivil = numeroRegistroCivil_text.getText();
            String sexo = combo_sexo.getValue();
            String fechaNacimiento = fechaNacimiento_text.getValue() + "";
            String fechaIngreso = fechaIngreso_Text.getValue() +"";
            String grado = combo_grado.getValue();
            
            obsLista.set(tablaMatriculas.getSelectionModel().getSelectedIndex(), 
                    new Matricula(numeroMatricula,nombre,apellido,registroCivil,sexo,fechaNacimiento,fechaIngreso,grado));  
           
            Matricula nueva = new  Matricula(numeroMatricula,nombre,apellido,registroCivil,sexo,fechaNacimiento,fechaIngreso,grado);
            if (!bd.UPDATE_MATRICULA(nueva)) 
            {
                    mensaje("ERROR","ACTUALIZACION CORRECTA", Alert.AlertType.CONFIRMATION);
            }
            else{
        
                mensaje("ERROR","NO SELECCIONO NINGUNA MATRICULA",Alert.AlertType.ERROR);
            }
        
        }
    }
    
    @FXML
    public void eliminarMatricula()
    {
       
        if (!tablaMatriculas.getSelectionModel().isEmpty()) 
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("ELIMINAR MATRICULA");

            alert.setTitle("Eliminar Matricula");
            alert.setContentText("¿Deseas realmente Eliminar la Matricula?");
            
            Optional<ButtonType> action = alert.showAndWait();
        
            if (action.get() == ButtonType.OK) 
            {  
            
            String numero = tablaMatriculas.getSelectionModel().getSelectedItem().getNumeroMatricula();
            System.out.println(numero);
                if(!bd.DELETE_MATRICULA(numero))
                {
                    obsLista.remove(tablaMatriculas.getSelectionModel().getSelectedItem());
                    mensaje("EXITO", "SE ELIMINO LA MATRICULA",Alert.AlertType.CONFIRMATION);
                    
                }
            
            
            }
        }
        else
        {
            mensaje("ERROR", "NO SELECCIONO NINGUNA NOTA",Alert.AlertType.CONFIRMATION);
        }
        
    
    }
    
     
    @FXML
    void verDatosMatricula()
    {
        if (!tablaMatriculas.getSelectionModel().isEmpty())
        {
           
            numeroMatricula_text.setText(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getNumeroMatricula());
            nombre_text.setText(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getNombre());
            apellido_text.setText(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getApellido());
            numeroRegistroCivil_text.setText(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getNumeroRegistroCivil());
            combo_sexo.setValue(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getSexo());
            fechaNacimiento_text.setValue( LocalDate.parse(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getFechaIngreso()));
            fechaIngreso_Text.setValue( LocalDate.parse(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getFechaNacimiento()));
            combo_grado.setValue(tablaMatriculas.getSelectionModel().getSelectedItems().get(0).getGrado());
           
        }
                
    }
    
    
    void mensaje(String titulo, String info,Alert.AlertType tipo) 
    {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(info);
        alert.showAndWait();
    }
   
}
