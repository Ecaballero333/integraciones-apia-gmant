package uy.com.st.integration.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.Test;

import uy.com.st.integration.common.utils.ZipUtil;

class ZIPUtilsTest {
	
	@Test
	public void comprimirTexto() throws IOException {
		String elementosXML = this.getTextoLargo();
		String textoComprimido = ZipUtil.comprimirTexto(elementosXML);
		assertTrue(elementosXML.length() > textoComprimido.length());	
	}
	
	@Test
	public void descomprimirTexto() throws IOException, JAXBException {
		String elementosXML = this.getTextoLargo();
		String textoComprimido = ZipUtil.comprimirTexto(elementosXML);
		String textoDescomprimido = ZipUtil.descomprimirTexto(textoComprimido);
		assertEquals(elementosXML, textoDescomprimido);
	}

	private String getTextoLargo() {
		return "Características\r\n" + 
				"Según su creador una wiki es \"la base de datos en línea más simple que pueda funcionar\". Se trata de un tipo de página web que brinda la posibilidad de que multitud de usuarios puedan editar sus contenidos a través del navegador web, con ciertas restricciones mínimas. De esta forma permite que múltiples autores puedan crear, modificar o eliminar los contenidos. Se puede identificar a cada usuario que realiza un cambio y recuperar los contenidos modificados, volviendo a un estado anterior. Estas características facilitan el trabajo en colaboración así como la coordinación de acciones e intercambio de información sin necesidad de estar presentes físicamente ni conectados de forma simultánea. El ejemplo más conocido y de mayor tamaño de este tipo de páginas web es la enciclopedia colaborativa Wikipedia (www.wikipedia.org). A favor: Es una fuente de información y bibliográfica de construcción colectiva. Problemas: La información publicada puede provenir de fuentes erróneas o no válidas. Solución/recomendaciones: Es recomendable trabajar criterios sobre el empleo de fuentes de información confiables y formas de validar los contenidos.4​\r\n" + 
				"\r\n" + 
				"Una wiki permite que se escriban artículos colectivamente (coautoría) por medio de un lenguaje de wikitexto editado mediante un navegador. Una página wiki singular es llamada «página wiki», mientras que el conjunto de páginas (normalmente interconectadas mediante hipervínculos) es «la wiki». Es mucho más sencillo y fácil de usar que una base de datos.\r\n" + 
				"\r\n" + 
				"Una característica que define la tecnología wiki es la facilidad con que las páginas pueden ser creadas y actualizadas. En general no hace falta revisión para que los cambios sean aceptados. La mayoría de las wikis están abiertos al público sin la necesidad de registrar una cuenta de usuario. A veces se requiere conectarse para obtener una cookie de «wiki-firma», para autofirmar las ediciones propias. Otras wikis más privadas requieren autenticación de usuario.\r\n" + 
				"\r\n" + 
				"Perspectivas pedagógicas de Wiki\r\n" + 
				"Por lo explicado, las wikis son una muy buena opción pedagógica para realizar actividades educativas, ya que como explica Mariana Maggio, se pueden generar propuestas que los alumnos puedan integrar en las wikis a partir de la reconstrucción de las mismas en un sentido didáctico. En la actualidad los documentos Web, como lo es el ejemplo de las wikis, crean tendencias y cuando estas configuran los usos de los niños y los jóvenes, es importante que los educadores las reconozcan y se preocupen por entenderlas a partir de su exploración.\r\n" + 
				"\r\n" + 
				"Para Maggio, «un proyecto didáctico maravilloso puede ser, cuando el tema lo justifique, generar contenidos para Wikipedia o revisar los publicados allí: entender el tema de un modo profundo, verificar los contenidos, transparentar y discutir los criterios, ampliar lo publicado, ofrecer versiones y especificaciones de alto valor local».5​\r\n" + 
				"\r\n" + 
				"Una wiki también puede ser un espacio usado para seguimiento individual de los alumnos, donde ellos puedan crear sus proyectos independientemente y el profesor pueda intervenir guiando y corrigiendo. Se ha utilizado también en procesos de formación docente ayudando al mejoramiento de sus habilidades tecnológicas, pero también los procesos de colaboración entre pares.6​Permite la creación colectiva de documentos en un lenguaje simple de marcas utilizando un navegador web. Generalmente no se hacen revisiones previas antes de aceptar las modificaciones y la mayoría de las wikis están abiertas. Permite a los participantes trabajar juntos en páginas web, para añadir o modificar su contenido. Las versiones antiguas nunca se eliminan y pueden restaurarse. Se puede seleccionar diferentes tipos de wiki, profesor, grupo, alumno.\r\n" + 
				"\r\n" + 
				"Páginas y edición\r\n" + 
				"En una wiki tradicional, existen tres representaciones por cada página:\r\n" + 
				"\r\n" + 
				"El «código fuente» que pueden editar los usuarios. Es el formato almacenado localmente en el servidor. Normalmente es texto plano, solo es visible para el usuario cuando lo muestra la operación «Editar».\r\n" + 
				"Una plantilla (en ocasiones generada internamente) que define la disposición y elementos comunes de todas las páginas.\r\n" + 
				"El código HTML, puesto en tiempo real por el servidor a partir del código fuente cada vez que la página se solicita.\r\n" + 
				"El código fuente es potenciado mediante un lenguaje de marcado simplificado para hacer varias convenciones visuales y estructurales. Por ejemplo, el uso del asterisco «*» al empezar una línea de texto significa que se generará una lista desordenada de elementos (bullet-list). El estilo y la sintaxis pueden variar en función de la implementación, alguno de las cuales también permite etiquetas HTML.\r\n" + 
				"\r\n" + 
				"¿Por qué no HTML?\r\n" + 
				"La razón de este diseño es que el HTML, con muchas de sus etiquetas crípticas, es difícil de leer para usuarios no habituados a la tecnología. Hacer visibles las etiquetas de HTML provoca que el texto en sí sea difícil de leer y editar para la mayoría de usuarios. Por lo tanto, se promueve el uso de edición en texto llano con convenciones para la estructura y el estilo fáciles de comprender.\r\n" + 
				"\r\n" + 
				"A veces es deseable que los usuarios no puedan usar ciertas funcionalidades que el HTML permite, tales como JavaScript, CSS y XML. Se consigue consistencia en la visualización, así como seguridad adicional para el usuario. En muchas inserciones de wiki, un hipervínculo es exactamente tal como se muestra, al contrario de lo que ocurre en el HTML.\r\n" + 
				"\r\n" + 
				"Estándar\r\n" + 
				"Durante años el estándar de facto fue la sintaxis del WikiWikiWeb original. Actualmente las instrucciones de formateo son diferentes dependiendo del motor de la wiki. Las wikis simples permiten solo formateo de texto básico, mientras que otros más complejos tienen soporte para cuadros, imágenes, fórmulas e incluso otros elementos más interactivos tales como encuestas y juegos. Debido a la dificultad de usar varias sintaxis, se están haciendo esfuerzos para definir un estándar de marcado (ver esfuerzos de Meatball y Tikiwiki).\r\n" + 
				"\r\n" + 
				"Vincular y crear páginas\r\n" + 
				"Los wikis son un auténtico medio de hipertexto, con estructuras de navegación no lineal. Cada página contiene un gran número de vínculos a otras páginas. En grandes wikis existen las páginas de navegación jerárquica, normalmente como consecuencia del proceso de creación original, pero no es necesario usarlas. Los vínculos se usan con una sintaxis específica, el «patrón de vínculos».\r\n" + 
				"\r\n" + 
				"CamelCase\r\n" + 
				"Originalmente, la mayoría de las wikis usaban CamelCase como patrón de vínculos, poniendo frases sin espacios y poniendo la primera letra de cada palabra en mayúscula (por ejemplo, la palabra «CamelCase»). Este método es muy fácil, pero hace que los hiperenlaces se escriban de una manera que se desvía de la escritura estándar. Las wikis basadas en CamelCase se distinguen instantáneamente por los enlaces con nombres como: «TablaDeContenidos», «PreguntasFrecuentes». Por consiguiente, comenzaron a desarrollarse otras soluciones.";
	}		
}
