package br.gov.ma.tce.obralegal.server.beans.material;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.ma.tce.obralegal.server.beans.obraservico.ObraServico;

@Entity(name = Material.NAME)
@Table(schema = "obralegal", name = "material")
public class Material implements Serializable {
	public static final String NAME = "obralegal_Material";
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "obralegal.seq_material", sequenceName = "obralegal.seq_material", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obralegal.seq_material")
	@Column(name = "material_id", columnDefinition = "INT4")
	private Integer materialId;

	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "quantidade", columnDefinition = "FLOAT8")
	private Double quantidade;

	@ManyToOne
	@JoinColumn(name = "obra_servico_id", columnDefinition = "INT4")
	private ObraServico obraServico;

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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
		result = prime * result + ((materialId == null) ? 0 : materialId.hashCode());
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
		Material other = (Material) obj;
		if (materialId == null) {
			if (other.materialId != null)
				return false;
		} else if (!materialId.equals(other.materialId))
			return false;
		return true;
	}

}
