

package interfaces;
import java.util.ArrayList;
import models.Song;


/**
 * Interface de metodos generales y de la clase C
 * @author andre
 *
 */
public interface ICarC {
	/**
	 * @return El estado de la radio cambiado
	 */
	public boolean SwitchRadioONOFF();
	
	/**
	 * Obtener el estatus de la radio encendido/apagado
	 * @return status of the radio
	 */
	public boolean getRadioStatus();
	
	/**
	 * El volumen que sube o disminuye de 1 en 1
	 * @return Obtener el valor actual del volumen
	 */
	public int getVolume();
	
	/**
	 * El volumen que sube o disminuye de 1 en 1
	 * @param Volume El volumen actual
	 */
	public void setVolume(int Volume);
	
	/**
	 * Metodo para cambiar el tipo de frecuencia de FM a AM
	 * si es falso es AM
	 * @return el valor cambiado de la frecuencia
	 */
	public boolean SwitchFrequency();
	
	
	/**
	 * Metodo para obtener el tipo frecuencia de FM a AM
	 Si este es verdadero significa que es FM, si es falso es AM
	 * @return el valor de la frecuencia
	 */
	public boolean getFrequency();
	
	
	/**
	 * Cambiar la estacion actual de la radio (Solo debe de cambiarse de 0.5 en 0.5)
	 * @param stationChange el valor por el cual se va a cambiar la varible de la raio (0.5 o -0.5)
	 */
	public void setStation(float stationChange);
	
	/**
	 * Obtener el valor actual de la radio
	 * @return el valor actual de la radio
	 */
	public float getStation();
	
	
	public void SaveStation(float _station);
	
	/**
	 * Metodo para poner una estacion especifica, guardada en la lista, por medio
	 * de el indice de su posicion en la lista
	 * @param _StationIndex Indice o posicion que se desea obtener
	 * @return La emisora que se encontraba en el indice solicitado
	 */
	public float SelectSpecificStation(int _StationIndex);
	
	/**
	 * Este metodo se encarga de regresar el valor del tipo de reproduccion
	 * 1(Reproduccion de CD) 2(Reproduccion de MP3) 3 (Reproduccion de Spotify)
	 * @return Numero que representa el tipo de reproductor
	 */
	public int getAudioRepType();
	
	/**
	 * Este metodo se encarga de cambiar el valor del tipo de reproduccion
	 * 1(Reproduccion de CD) 2(Reproduccion de MP3) 3 (Reproduccion de Spotify)
	 */
	public void setAudioRepType(int repType);
	
	/**
	 * Metodo que se encarga de obtener una de las listas de canciones pre definidas
	 * Hay 3 tipos de listas (Lista 1 , lista de canciones en CD), (Lista 2, lista de canciones
	 * en spotify), (Lista 3, lista de canciones MP3)
	 * @return Lista de canciones en funcion del tipo de que se solicita
	 */
	public ArrayList<Song> getAListOfSongs(int TypeOfAudioReproduction);
	
	/**
	 * Metodo que se encarga de cambiar el indice actual de la lista de reproduccion. 
	 * Para ir a la siguiente cancion. Se obtiene el tipo de reproduccion para saber a 
	 * cual de las 3 listas se ledebe cambiar el indice actual
	 * @param TypeOfAudioReproduction
	 * @param CurrentIndex
	 */
	public void NextSong(int CurrentIndex, int TypeOfAudioReproduction);
	
	/**
	 * Metodo que se encarga de cambiar el indice actual de la lista de reproduccion.
	 * Para ir a la cancion anterior. Se obtiene el tipo de reproduccion para saber a cual de las 3 listas 
	 * se le debe cambiar el indice actual
	 * @param TypeOfAudioReproduction
	 * @param CurrentIndex
	 */
	public void PrevSong(int CurrentIndex, int TypeOfAudioReproduction);
	
	/**
	 * Este metodo se encarga de regresar una cadena de texto que muestra las caracteristicas
	 * de la cancion que se encuentra en el indice actual. EL indice actual se guarda como una variable dentro
	 * del objecto carro, y unicamente es necesario solicitar el tipo de lista que se esta reproduciendo
	 * @return Cadena de texto de la lista que se solicita, en la posicion actual
	 */
	public String PlaySong(int TypeOfAudioReproduction);
	
	/**
	 * Metodo que cambia el estado de telefono conectado (verdadero o falso)
	 * @return el valor cambiado de la conexion con el telefono
	 */
	
	public boolean Connect_DisconnectPhone();
	
	/**
	 * Metodo para obtener el estatus de conexion del telefono
	 * si esta conectado o no
	 * @return estado de conexion de telefono
	 */
	public boolean getPhoneConnectionStatus();
	
	/**
	 * Obteniendo la lista de contactos, Contiene el nombre de las personas.
	 * No debe de haber nombres iguales en la lista y los nombres pueden estar definidos dentro
	 * del programa
	 * @return
	 */
	public ArrayList<String> getListofContacts();
	
	/**
	 * Obtener el valor de llamada, si el telefono esta en llamada, en espera
	 * o si no esta en llamada. A cada opcion le corresponde un numero
	 * @return estatus de llamada
	 */
	public int getCallStatus();
	
	/**
	 * Metodo para hacer una llamada, este metodo
	 * verifica si la llamada es posible, y si lo es, regresar
	 * un mensaje que contenga el nombre de la persona que se esta llamando
	 * @param NameforCall
	 * @return Mensaje de llamando
	 */
	public String makeCall(String NameforCall);
	
	/**
	 * Metodo para cambiar el estatus de llamada a en espera
	 * @return mensaje de persona puesta en espera
	 */
	public String PlaceCallOnHold();
	
	/**
	 * Terminar la llamada y cambiar status
	 * @return mensaje de fin de llamada
	 */
	public String endCall();
	
	/**
	 * Obtener el pronostico de tiempo. Queda a disposicion como obtener el clima
	 * o si se deja un clima definido dentro del codigo.
	 * @return Texto que indica el clima actual (real o simulado)
	 */
	public String getWeatherForCast();
	
}