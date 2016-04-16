class CreateLabels < ActiveRecord::Migration
  def change
    create_table :labels do |t|
      t.integer :question_id
      t.string :name
      t.references :user, index: true, foreign_key: true

      t.timestamps null: false
    end
    add_index :labels, :question_id
  end
end
