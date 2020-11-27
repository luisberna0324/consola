package com.soltelec.consola.facade;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public interface basicoFacade  {
	
public String getFindVehiculoForPlaca(String placa) ;
public String valAutUserDominio(String user, String password) ;
public String servRegManualRunt(String streaming) ;
public String servRegAutomaticoRunt(String streaming);
public String servAutorizacionPreRevision(String streaming);
public String procStreamingDocPropiedad(String streaming);
public String procStreamingDocCedula(String streaming);
public String servPersistRegistroCedula(String streaming);
public String servPersistRechazoVehiculo(String streaming);
public String servInspeccionPreRevision(String streaming, String idPreRevision);
public String servPersistPreRevision2Fase(String streaming);
public String servPersistFirmaRechazo(InputStream firma, String noRevision);
public byte[] restoredFirmaRechazo(String noRevision);
public String servPersistNovedad(InputStream evidencia, String noRevision, String obsPerpectiva, Integer handler, Integer contexto);
public String servUltimaPreRevision(String placa);
public List<byte[]> servFindEvidencias(Integer fkPreRevision);
public String servFindOrdenPreRevision(String streaming);
public String servBuiltGrafoHP(Integer fkPreRevision);
public String servFindClasesVehiculoAct();
public String servFindCtxCDA();
public String servRegistroUsuario(InputStream firma, String streaming);
public String servExixtenciaNickUsuario(String strNickUsuario);
public String servFindUsuario(String strCedula);
public String servUpdateUsuario(InputStream firma, String strAtrUser);
public byte[] servFindFirmaUsuario(String strCedula);
public String servRegistroPSI(String idPreRevision, String streaming);
public String servFindDatosRecepcion(String noRevision);
public String servConfirmDatosRunt(String atrrConfirmacion);
public String servFindDatosConductor(String streaming);
public String servFindDatosUbicacionConductor(String streaming);
public String servActualizarDatosConductor(String streaming);
public String servAutorizacionVehPista(String fkRevision, String nroFactura, String nroPin);
public String setFechaInicioRecepcion(Integer fkRevision, Integer usuario);
public String servFindDatosSoat(String noRevision);
public String servFindExisRevision(String placa);
public String servConfirmDatosSoat(String atrrConfirmacion);
public String servFindDatosPropietario(String streaming);
public String servFindFuncConsola(String placa);
public String servFuncCmbEdoSicov(String strAtributos);
public String servFuncCmbTipoRevision(String strAtributos);
public String servFuncCambioPlaca(String strAtributos);
public String servFuncAnularRTM(String strAtributos);
public String servFuncCorregirPin(String strAtributos);
public String servFindHojaPruebasAbiertas(String streams);
public String servFindStatusPruebas(String testSheet);
public String servPersistFotoPrueba(InputStream pictureFoto, Integer identPrueba, Integer identHojaPrueba, String identCondicion, Integer fkUser);
public String servEstadisticaHojaPruebaFor1Vez(String tipoRevision, Date fechaIni, Date fechaFin);
public String servEstadisticaMovRTM(String tipoRevision, Date fechaInicial, Date fechaFinal);
public String servEstadisticaAnalisisPruebas(Integer tipoPrueba, Date fechaInicial, Date fechaFinal);
public String servInformeRevision(Date fechaInicial, Date fechaFinal);
public String setInformeRecPista(Date fechaInicial);
public String setAnulacionPreRevision(Integer nroPreRevision);
public String setPanelConfiguracionCda(String strAtributosCda);
public String servFindDepartametos();
public String servFindCiudades(Integer identCiudad);
public String serPersitProfLabrado(String strProfundidaLabrado);
public String servCtxShowDefectos(String ctxInpeccSensorial);
public String servSetDefectoPrueba(String strDefectos);
public String servSetCierrePrueba(String strParametroPrueba);
public String servFindEstadoPruebas(String strParametroPrueba);
public String servSetObservacionesPruebas(String strParametroPrueba);
public String serPersitProfLabradoLiviano(String strProfundidaLabrado);
public String servFindCtxFotos(String ctxHojaPrueba);
public String servFindVehiculo(String placa);
public String BusqColoresExist(String strColores);
public String busqAseguradoraExist(String strAseguradora);
public String servFindOrdenBienvenida();
public String busqMarcaExist(String strMarca);
public String servFindCtxPreRevision(String streaming);
public String servRegistroInventario(String streaming);

}
