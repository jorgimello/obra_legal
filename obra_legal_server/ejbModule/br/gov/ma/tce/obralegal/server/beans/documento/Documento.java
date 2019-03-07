package br.gov.ma.tce.obralegal.server.beans.documento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.ma.tce.obralegal.server.beans.obraservico.ObraServico;
import br.gov.ma.tce.obralegal.server.tipodocumento.TipoDocumento;

@Entity(name = Documento.NAME)
@Table(schema = "obralegal", name = "documento")
public class Documento implements Serializable {
	public static final String NAME = "obralegal_Documento";
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "obralegal.seq_documento", sequenceName = "obralegal.seq_documento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obralegal.seq_documento")
	@Column(name = "documento_id", columnDefinition = "INT4")
	private Integer documentoId;

	@Column(name = "tipo", columnDefinition = "TEXT")
	private String tipo;
	
	@Column(name = "nome_arquivo", columnDefinition = "TEXT")
	private String nomeArquivo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_documento", columnDefinition = "TEXT")
	private TipoDocumento tipoDocumento;

	@ManyToOne
	@JoinColumn(name = "obra_servico_id", columnDefinition = "INT4")
	private ObraServico obraServico;

	public Integer getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public ObraServico getObraServico() {
		return obraServico;
	}

	public void setObraServico(ObraServico obraServico) {
		this.obraServico = obraServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentoId == null) ? 0 : documentoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (documentoId == null) {
			if (other.documentoId != null)
				return false;
		} else if (!documentoId.equals(other.documentoId))
			return false;
		return true;
	}
}