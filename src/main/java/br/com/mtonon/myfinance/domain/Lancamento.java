package br.com.mtonon.myfinance.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.mtonon.myfinance.domain.enums.StatusLancamento;
import br.com.mtonon.myfinance.domain.enums.TipoLancamento;

@Entity
@Table(name = "usuario", schema = "finance")
public class Lancamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "mes")
	private Integer mes;
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "valor")
	private Double valor;
	
	@ManyToOne /* Relação Muitos Lançamentos para Um Usuário */
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo")
	private TipoLancamento tipo;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private StatusLancamento status;
	
	public Lancamento() {
	}

	public Lancamento(Long id, String descricao, Integer mes, Integer ano, Double valor, Usuario usuario,
			LocalDate dataCadastro, TipoLancamento tipo, StatusLancamento status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
		this.valor = valor;
		this.usuario = usuario;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public StatusLancamento getStatus() {
		return status;
	}

	public void setStatus(StatusLancamento status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(id, other.id);
	}
}
